<template>
    <div class="container">
        <div class="row mt-5">
            <div class="col-md-6 col-sm-6 col-xs-6">
                <b-form>
                    <h6>Owner: {{selectedOwner.firstName}} {{selectedOwner.lastName}}</h6>
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
                        <b-form-datepicker id="example-datepicker" v-model="pet.birthDate" class="mb-2"></b-form-datepicker>
                    </b-form-group>
                    <b-form-group
                            id="input-group-4"
                            label="PetType"
                            label-for="input-4"
                    >
                        <b-form-select v-model="pet.petType.name" :options="options"></b-form-select>
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
                },
                options: [],
            }
        },
        computed: {
            ...mapGetters(['selectedOwner', 'petTypes'])
        },
        created() {
            this.petTypes.forEach(petType => {
                let option = {};
                option.value = petType;
                option.text = petType;
                this.options.push(option);
            })
        },
        methods: {
            addPet() {
                axios.post('/pets/addPet/' +this.selectedOwner.id, this.pet).then(res => {
                    console.log(res.data);
                    this.$store.dispatch('setSelectedOwner', res.data);
                    this.$router.push({path: '/owners/detailView'});
                }).catch(error => {
                    console.log(error);
                })
            }
        }
    }
</script>

<style scoped>

</style>