<template>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12">
                <br>
                <h3>List of Owners</h3>
                <br>
                <b-table :items="owners"></b-table>
            </div>
        </div>
    </div>
</template>
<script>
    import axios from 'axios';
    export default {
        data() {
            return {
                owners: []
            }
        },
        created() {
            axios.get('/getOwners').then(res=> {
                console.log(res.data);
                this.owners = res.data;
            })
            .catch(error => {
                console.log(error);
            })
        }
    }
</script>