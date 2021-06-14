/**
 * Ilman Nawali 1972003
 */
public class Cinema {
    private int numberOfStudio=10;
    private Film[] films;
    public Cinema() {
        Film[] isi=new Film[10];
        this.films=isi;
    }
    public Film[] getFilms(){
        return films;
    }
    public int getNumberOfStudio(){
        return numberOfStudio;
    }

    public void setNumberofStudio() {
        this.numberOfStudio-=1;
    }
    public Film[] getLongestFilm(){
        Film []panjang=new Film[1];
        if (numberOfStudio==10){
            return null;
        }
        else{
            panjang[0]=films[0];
            for (int i=1; i<10;i++){
                if (films[i]!=null) {
                    if (panjang[0].getDuration() < films[i].getDuration()) {
                        panjang[0] = films[i];
                    }
                }
            }
            return panjang;
        }
    }
    public Film[] getShortestFilm(){
        Film []pendek=new Film[1];
        if (numberOfStudio==10){
            return null;
        }
        else{
            pendek[0]=films[0];
            for (int i=1; i<10;i++){
                if (films[i]!=null) {
                    if (pendek[0].getDuration() > films[i].getDuration()) {
                        pendek[0] = films[i];
                    }
                }
            }
            return pendek;
        }
    }
}
