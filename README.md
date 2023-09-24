# selenium

Required dependency:
- selenium-java
- testng

how can we use config.properties:

prop = new Properties();
File propFile = new File("src/test/java/resources/config.properties");
try {
FileInputStream file = new FileInputStream(propFile);
prop.load(file);
} catch (IOException e) {
throw new RuntimeException(e);
}

