package ica.oose.vagado;

public class PuntentellingContext {

        private Puntentelling puntentelling;

        public PuntentellingContext(Puntentelling puntentelling){
            this.puntentelling = puntentelling;
        }

        public int bereken(int aantalGoedeAntwoorden, double speelTijd){
            return puntentelling.berekenScore(aantalGoedeAntwoorden, speelTijd);
        }
}
