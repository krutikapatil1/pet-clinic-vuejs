<template>
    <div class="container">
        <div class="row mt-5">
            <div class="col-md-12">
                <b-form>
                    <h6>Owner: {{selectedOwner.firstName}} {{selectedOwner.lastName}}</h6>
                    <h6>Pet Name: {{pet.name}}</h6>
                    <h6>Pet Type: {{pet.petType.name}}</h6>
                    <b-form-group
                            id="input-group-3"
                            label="Visit Description"
                            label-for="input-3"
                    >
                        <b-form-input
                                id="input-3"
                                v-model="visit.description"
                                required
                                placeholder="Enter Description"
                        ></b-form-input>
                    </b-form-group>
                    <b-form-group
                            id="input-group-4"
                            label="Visit Date"
                            label-for="input-4"
                    >
                        <b-form-datepicker id="example-datepicker" v-model="visit.date"
                                           class="mb-2"></b-form-datepicker>
                    </b-form-group>
                    <button class="btn btn-dark" @click.prevent="editVisit">Submit</button>
                </b-form>
            </div>
        </div>
    </div>
</template>

<script>
    import {mapGetters} from 'vuex';
    import axios from 'axios';

    export default {
        name: "EditVisit",
        data() {
            return {
                pet: {},
                visit: {}
            }
        },
        created() {
            let pets = this.selectedOwner.pets;
            for (let i = 0; i < pets.length; i++) {
                if (pets[i].id == this.$route.params.petId) {
                    this.pet = pets[i];
                    break;
                }
            }
            if (this.pet != null) {
                for (let i = 0; i < this.pet.visits.length; i++) {
                    if (this.pet.visits[i].id == this.$route.params.visitId) {
                        this.visit = this.pet.visits[i];
                        break;
                    }
                }
            }
        },
        computed: {
            ...mapGetters(['selectedOwner'])
        },
        methods: {
            editVisit() {
                axios.post('/visits/addVisit/' + this.pet.id, this.visit).then(res => {
                    console.log(res.data);
                    this.$store.dispatch('setSelectedOwner', res.data);
                }).catch(error => {
                    console.log(error);
                })
            }
        }
    }
</script>

<style scoped>

</style>