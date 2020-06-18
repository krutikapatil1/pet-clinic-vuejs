<template>
    <div class="container">
        <div class="row mt-5">
            <div class="col-md-6 col-sm-6 col-xs-6">
                <b-form>
                    <b-form-group
                            id="input-group-1"
                            label="Name"
                            label-for="input-1"
                    >
                        <b-form-input
                                id="input-1"
                                :value="selectedOwner.firstName + ' ' +selectedOwner.lastName"
                        ></b-form-input>
                    </b-form-group>
                    <b-form-group
                            id="input-group-2"
                            label="Name"
                            label-for="input-2"
                    >
                        <b-form-input
                                id="input-2"
                                v-model="pet.name"
                                required
                                placeholder="Enter Name"
                        ></b-form-input>
                    </b-form-group>
                    <b-form-group
                            id="input-group-3"
                            label="Birth Date"
                            label-for="input-3"
                    >
                        <b-form-input
                                id="input-3"
                                v-model="pet.birthDate"
                                required
                                placeholder="Enter BirthDate"
                        ></b-form-input>
                    </b-form-group>
                    <b-form-group
                            id="input-group-4"
                            label="PetType"
                            label-for="input-4"
                    >
                        <b-form-input
                                id="input-4"
                                v-model="pet.petType.name"
                                required
                                placeholder="Enter PetType"
                        ></b-form-input>
                    </b-form-group>
                    <button class="btn btn-dark" @click.prevent="addPet">Submit</button>
                </b-form>
            </div>
        </div>
    </div>
</template>

<script>
    import { mapGetters } from 'vuex';
    import axios from 'axios';
    export default {
        name: "AddPet",
        data() {
            return {
                pet: {
                    name: '',
                    petType: {
                        name: ''
                    },
                    birthDate: ''
                }
            }
        },
        computed: {
            ...mapGetters(['selectedOwner'])
        },
        methods: {
            addPet() {
                axios.post('/pets/addPet/' +this.selectedOwner.id, this.pet).then(res => {
                    console.log(res.data);
                }).catch(error => {
                    console.log(error);
                })
            }
        }
    }
</script>

<style scoped>

</style>