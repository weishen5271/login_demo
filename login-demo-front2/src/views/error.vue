<template>
    <div>
        <h1>登录错误!{{msg}}</h1>
    </div>
</template>

<script>
    export default {
        name: "error",
        data() {
            return {
                msg : null
            };
        },
        create(){
            this.msg = this.$route.query.message;
        }
    }


</script>

<style scoped>

</style>
