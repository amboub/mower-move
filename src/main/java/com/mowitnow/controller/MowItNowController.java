package com.mowitnow.controller;

import com.mowitnow.Parser.MowItNowParser;
import com.mowitnow.model.Mower;
import com.mowitnow.service.MowItNowService;
import com.mowitnow.service.impl.MowItNowServiceImpl;
import spark.ModelAndView;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * @author amine
 */
public class MowItNowController {

    public static void main(String[] args) {
        MowItNowService mowItNowService = new MowItNowServiceImpl();
        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("hasNoMowers", "");

            return new ModelAndView(attributes, "mowItNow.ftl");
        }, new FreeMarkerEngine());

        post("/mowItNow", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            MultipartConfigElement multipartConfigElement = new MultipartConfigElement("/tmp");
            request.raw().setAttribute("org.eclipse.multipartConfig", multipartConfigElement);

            List<Mower> mowersPosition = null;
            try {
                Part file = request.raw().getPart("file");
                MowItNowParser parser = new MowItNowParser(file.getInputStream());
                mowersPosition = mowItNowService.getMowersPosition(parser.getMowers(), parser.getSurface());
            } catch (Exception ignored) {
                attributes.put("hasNoMowers", "Une erreur est survenue");
            }

            attributes.put("positions", mowersPosition);
            return new ModelAndView(attributes, "mowItNow.ftl");
        }, new FreeMarkerEngine());
    }

}
