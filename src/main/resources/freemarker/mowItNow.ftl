<!DOCTYPE html>

<html>
  <head>
    <title>Welcome</title>
    <style type="text/css">
      .error {color: red}
    </style>

  </head>

  <body>
    <form action="/mowItNow"
          enctype="multipart/form-data" method="post">
        <p>
            Please specify a file:<br>
            <input type="file" name="file" size="40">
        </p>

        <div>
            <input type="submit" value="Send">
        </div>
    </form>

    <#if hasNoMowers??>
        <p class="error">${hasNoMowers}</p>
    <#else>
        <#list positions as position>
            <h4>${position.getPosition().getX()} ${position.getPosition().getY()} ${position.getOrientation()}</h4>
        </#list>
    </#if>


  </body>

</html>
