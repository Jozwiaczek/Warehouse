package start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot.pojazd;

public enum RodzajMotor {

    Sportowy(1),
    Turystyczny(2),
    Nagi(3),
    Crusier(4),
    Chopper(5);

    private int id;

    RodzajMotor(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }
}
