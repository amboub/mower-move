# mower-move
Deux façon pour tester l'application:
  1. mvn compile exec:java -Dexec.mainClass=com.mowitnow.controller.MowItNowController ensuite aller dans http://localhost:4567
  2. mvn compile exec:java -Dexec.mainClass=com.mowitnow.MowItNow -Dexec.args="Le chemin vers le fichier contenant les données d'entrée"
