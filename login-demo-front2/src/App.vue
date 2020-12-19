<template>
  <div>
    <el-container>
      <el-header><h2>{{$store.state.name}}</h2></el-header>
      <el-container>
        <el-aside width="200px"><NavMenu></NavMenu></el-aside>
        <el-main>
          <Device></Device>
          <chart></chart>
          <router-view></router-view>
        </el-main>
      </el-container>
      <el-footer>Footer</el-footer>
    </el-container>
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

