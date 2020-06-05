<template>
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-xs-12 col-sm-12">
                <br>
                <h3>List of Vets</h3>
                <br>
                <b-table :items="vets"></b-table>
            </div>
        </div>
    </div>
</template>
<script>
    import axios from 'axios';
    export default {
        data() {
            return {
                vets: []
            }
        },
        created() {
            axios.get('/getVets').then(res => {
                console.log(res.data);
                this.vets = res.data;
            })
            .catch(error => {
                console.log(error);
            })
        }
    }
</script>