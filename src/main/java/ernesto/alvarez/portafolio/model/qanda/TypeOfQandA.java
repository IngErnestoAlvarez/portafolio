package ernesto.alvarez.portafolio.model.qanda;

enum TypeOfQandA {

    PYTHON("src/main/resources/gamesQandA/python.json"), JAVA("gamesQandA/java.yaml"), CPP("gamesQandA/cpp.yaml");

    private String path;

    TypeOfQandA(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
