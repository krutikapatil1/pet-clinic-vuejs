<template>
    <div class="container">
        <div class="row mt-2">
            <div class="col-md-12 text-right">
                <button class="btn btn-dark" @click.prevent="addOwner">Add Owner</button>
            </div>
        </div>
        <div class="row mt-5">
            <div class="col-xs-3 col-sm-3 col-md-3">
                <h3>Search Owner</h3>
                <b-form>
                    <b-form-group
                            id="input-group-1"
                            label="Owner Lastname"
                            label-for="input-1"
                    >
                        <b-form-input
                                id="input-1"
                                v-model="lastName"
                                required
                                placeholder="Enter lastname"
                        ></b-form-input>
                    </b-form-group>
                    <p v-if="showError" style="color: red">No results found!</p>
                    <button class="btn btn-dark" @click.prevent="searchOwners">Find Owners</button>
                </b-form>
            </div>
            <div class="col-md-9 col-sm-9 col-xs-9">
                <router-view></router-view>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                lastName: '',
                showError: false
            }
        },
        watch: {
            '$route'(to) {
                if (to.path == '/owners') {
                    this.lastName = '';
                    this.$store.dispatch('resetData');
                }
            }
        },
        methods: {
            searchOwners() {
                this.$store.dispatch('loadOwnersSearchResults', this.lastName);
            },
            addOwner() {
                this.$router.push({path: '/addOwner'});
            }
        }
    }
</script>
