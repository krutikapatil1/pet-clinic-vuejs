<template>
    <div class="container">
        <br>
        <h3>{{welcomeMsg}}</h3>
        <div class="row">
            <div class="col-md-12 col-xs-12 col-sm-12">
                <img src="../assets/pets.png" alt="">
            </div>
        </div>
    </div>
</template>
<script>
    import axios from 'axios';
    export default {
        data() {
            return {
                welcomeMsg: ''
            }
        },
        created() {
            axios.get('/getWelcomeMsg').then(res=> {
                this.welcomeMsg = res.data;
            })
                .catch(error => {
                    console.log(error);
                })
        }
    }
</script>
<style scoped></style>