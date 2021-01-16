<template>

  <div id="home">

    <div id="Space">

      <Reservar/>

    </div>

    <div id="Space">

      <Timeline/>

    </div>

    <div id="Space">

      <Tabla/>

    </div>

  </div>

  
  

</template>

<script>
// @ is an alias to /src

import Reservar from '../components/Reservar.vue';
import Timeline from '../components/Timeline.vue'
import Tabla from '../components/Table.vue'


export default {
  name: 'Home',
  components: {
    Reservar,
    Timeline,
    Tabla,
  }
}
</script>

<style>
#home {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 3%;
  margin-left: 7%;
  margin-right: 7%;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

#Space{
  margin-top: 2%;
}
</style>