package com.awsft.knifeandmustache.dto;

public class BarberDTO {
        private String barberName;
        private String barberUrlSocial;

        public BarberDTO(String barberName, String barberUrlSocial) {
            this.barberName = barberName;
            this.barberUrlSocial = barberUrlSocial;
        }

        public String getBarberName() {
            return barberName;
        }
        public void setBarberName(String barberName) {
            this.barberName = barberName;
        }
        public String getBarberUrlSocial() {
            return barberUrlSocial;
        }
        public void setBarberUrlSocial(String barberUrlSocial) {
            this.barberUrlSocial = barberUrlSocial;
        }     
}
