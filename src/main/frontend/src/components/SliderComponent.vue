<template>
    <div class="q-pa-md carousel">
      <q-carousel
        arrows
        animated
        infinite
        v-model="slide"
        height="50vh"
        :autoplay="autoplay"
        transition-next="slide-left"
      >
    
        <q-carousel-slide name="first" img-src="../assets/images/AltJ.jpg">
          <div class="absolute-bottom custom-caption">
            <div class="text-h2">Alt J</div>
            <div class="text-subtitle1">14/04/2023</div>
          </div>
        </q-carousel-slide>
        <q-carousel-slide name="second" img-src="../assets/images/king-gizzar.jpg">
          <div class="absolute-bottom custom-caption">
            <div class="text-h2">King Gizzard & lizard Wizard</div>
            <div class="text-subtitle1">28/06/2023</div>
          </div>
        </q-carousel-slide>
        <q-carousel-slide name="third" img-src="../assets/images/TashSultana.jpeg">
          <div class="absolute-bottom custom-caption">
            <div class="text-h2">TashSultana</div>
            <div class="text-subtitle1">10/7/2023</div>
          </div>
        </q-carousel-slide> 
        <q-carousel-slide name="fourth" img-src="../assets/images/bonjovi.jpg">
          <div class="absolute-bottom custom-caption">
            <div class="text-h2">Bon Jovi</div>
            <div class="text-subtitle1">21/09/2023</div>
          </div>
        </q-carousel-slide>
        <q-carousel-slide name="fifth" img-src="../assets/images/madonna1.jpeg">
          <div class="absolute-bottom custom-caption">
            <div class="text-h2">Madonna</div>
            <div class="text-subtitle1">11/08/2023</div>
          </div>
        </q-carousel-slide>
        <q-carousel-slide name="sixth" img-src="../assets/images/losgatos.jpg">
          <div class="absolute-bottom custom-caption">
            <div class="text-h2">Los Gatos de Chernobyl</div>
            <div class="text-subtitle1">09/05/2023</div>
          </div>
        </q-carousel-slide>
      </q-carousel>
    </div>
  </template>
  
  <script>
  import { ref } from 'vue'
  
  export default {
    setup () {
      return {
        slide: ref('first'),
        autoplay:ref(true)
      }
    }
  }
  </script>
  
  <style lang="scss" scoped>
  .custom-caption {
    text-align: center;
    padding: 12px;
    color: white;
    background-color: rgba(0, 0, 0, .3);
  }

  .carousel {
    width: 80%;
  }
  </style>
  