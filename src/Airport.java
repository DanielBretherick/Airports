public class Airport {
    private String nome;
    private float latitude;
    private float longitude;

    public Airport(String nome, float latitude, float longitude){
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getLatitude() {
        return latitude;
    }
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    public float getLongitude() {
        return longitude;
    }
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
