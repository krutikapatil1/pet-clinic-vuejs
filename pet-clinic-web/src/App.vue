<template>
  <div id="app">
    <app-header></app-header>
    <router-view></router-view>
    <app-footer></app-footer>
  </div>
</template>

<script>
  import Header from './components/common/Header.vue';
  import Footer from './components/common/Footer.vue';
export default {
  name: 'App',
  components: {
    appHeader: Header,
    appFooter: Footer
  },
  created() {
    this.$store.dispatch('getAllPetTypes');
  }
}
</script>

<style>

</style>
