<template>
 
  <div class="q-pa-md">
    <q-layout view="lHh lpr lFf" container style="height: 600px" class="shadow-2 rounded-borders">
      <q-header class="header" reveal elevated>
        <q-toolbar>
          <q-btn flat round dense  class="q-mr-sm"><img class="iconHome" src="../assets/images/iconHome.png"></q-btn>


          <q-toolbar-title class="title_header">MUSIC EVENTS</q-toolbar-title>

          <q-btn flat round dense class="user"> <img class="iconUser" src="../assets/images/iconUser.png"></q-btn>
        </q-toolbar>
      </q-header>

      <q-footer class="footer" reveal elevated>
        <q-toolbar>
          <q-toolbar-title ><img class="logo" src="../assets/images/logo.png"></q-toolbar-title>
        </q-toolbar>
      </q-footer>

      <q-page-container>
        <q-page class="q-pa-md">
          <p v-for="n in 15" :key="n">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit nihil praesentium molestias a adipisci, dolore vitae odit, quidem consequatur optio voluptates asperiores pariatur eos numquam rerum delectus commodi perferendis voluptate?
          </p>
        </q-page>
      </q-page-container>
    </q-layout>
  </div>
</template>

<style lang="scss" scoped>

.q-pa-md{
  background-color: $dark-blue;
  margin: 0;
  padding: 0;
}


.header{
  background-color: $primary ;
  margin: 0;
  padding: 0;
  .q-mr-sm{
    height: 10em;
    .iconHome{
      max-width: 4em;
      max-height: 4em;
    }
  }
  .title_header{
    font-family: $font-title;
    display: flex;
    justify-content: center;
    font-size: 5em;
  }
  
  .user{
    .iconUser{
      max-width: 4em;
      max-height: 4em;
    }
  }
    
}
.footer{
  background-color: $dark-blue;
  

  .logo{
    display: flex;
    justify-content: center;
    margin-left: center;
  }
}


</style>