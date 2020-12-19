<template>
    <div>
        <h1>welcome!{{msg}}</h1>
    </div>
</template>

<script>
    export default {
        name: "success",
        data(){
            return {
                msg : this.$route.query.data
            }
        }
    }
</script>

<style scoped>

</style>
