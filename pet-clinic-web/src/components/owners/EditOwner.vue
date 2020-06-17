<template>
    <div class="container">
        <div class="row mt-5">
            <div class="col-md-6 col-sm-6 col-xs-6">
                <b-form>
                    <b-form-group
                            id="input-group-1"
                            label="First Name"
                            label-for="input-1"
                    >
                        <b-form-input
                                id="input-1"
                                v-model="selectedOwner.firstName"
                                required
                                placeholder="Enter FirstName"
                        ></b-form-input>
                    </b-form-group>
                    <b-form-group
                            id="input-group-2"
                            label="Last Name"
                            label-for="input-2"
                    >
                        <b-form-input
                                id="input-2"
                                v-model="selectedOwner.lastName"
                                required
                                placeholder="Enter LastName"
                        ></b-form-input>
                    </b-form-group>
                    <b-form-group
                            id="input-group-3"
                            label="Address"
                            label-for="input-3"
                    >
                        <b-form-input
                                id="input-3"
                                v-model="selectedOwner.address"
                                required
                                placeholder="Enter Address"
                        ></b-form-input>
                    </b-form-group>
                    <b-form-group
                            id="input-group-4"
                            label="City"
                            label-for="input-4"
                    >
                        <b-form-input
                                id="input-4"
                                v-model="selectedOwner.city"
                                required
                                placeholder="Enter City"
                        ></b-form-input>
                    </b-form-group>
                    <b-form-group
                            id="input-group-5"
                            label="Telephone"
                            label-for="input-5"
                    >
                        <b-form-input
                                id="input-5"
                                v-model="selectedOwner.telephone"
                                required
                                placeholder="Enter Telephone"
                        ></b-form-input>
                    </b-form-group>
                    <button class="btn btn-dark" @click.prevent="editOwner">Submit</button>
                </b-form>
            </div>
        </div>
    </div>
</template>

<script>
    import { mapGetters } from 'vuex';
    export default {
        name: "EditOwner",
        computed: {
            ...mapGetters(['selectedOwner'])
        },
        methods: {
            editOwner() {
                this.$store.dispatch('addUpdateOwner', this.selectedOwner);
            }
        }
    }
</script>

<style scoped>

</style>