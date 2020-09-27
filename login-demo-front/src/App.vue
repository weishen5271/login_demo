<template>
  <div>
    <NavMenu></NavMenu>
    <Device></Device>
    <chart></chart>
    <router-view></router-view>
  </div>
</template>

<script>
  import NavMenu from "./components/NavMenu.vue";
  import Device from "@/components/device/index";
  import chart from "@/components/device/chart";
  export default {
    components: {
      NavMenu: NavMenu,
      Device:Device,
      chart:chart
    },
  }
</script>

<style>
</style>

