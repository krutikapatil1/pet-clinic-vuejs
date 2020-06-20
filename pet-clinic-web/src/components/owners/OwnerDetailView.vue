<template>
    <div>
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <b-card-group deck>
                    <b-card
                            header="Owner Details"
                            header-tag="header"
                            header-bg-variant="success"
                            border-variant="success"
                            header-text-variant="white"
                    >
                        <b-card-text>
                            <table class="table table-borderless">
                                <tr>
                                    <td><strong>Name</strong></td>
                                    <td>{{selectedOwner.firstName + ' ' +selectedOwner.lastName}}</td>
                                </tr>
                                <tr>
                                    <td><strong>Address</strong></td>
                                    <td>{{selectedOwner.address}}</td>
                                </tr>
                                <tr>
                                    <td><strong>City</strong></td>
                                    <td>{{selectedOwner.city}}</td>
                                </tr>
                                <tr>
                                    <td><strong>Telephone</strong></td>
                                    <td>{{selectedOwner.telephone}}</td>
                                </tr>
                            </table>
                        </b-card-text>
                    </b-card>

                    <b-card
                            header="Pets and Visits"
                            header-tag="header"
                            border-variant="success"
                            header-bg-variant="success"
                            header-text-variant="white"
                    >
                        <b-card-text>
                            <ul v-for="(petVisit) in selectedOwner.pets" :key="petVisit.id">
                                <li>
                                    <p><strong>Pet Name:</strong> {{petVisit.name}}
                                        <i class="fa fa-pencil-square-o ml-2" aria-hidden="true" style="cursor: pointer" @click.prevent="editPet(petVisit.id)"></i>
                                        <i class="fa fa-trash-o ml-2" aria-hidden="true" style="cursor:pointer" @click.prevent="deletePet(petVisit.id)"></i>
                                        <i class="fa fa-plus-circle ml-2" aria-hidden="true" style="cursor: pointer" @click.prevent="addVisit(petVisit.id)"></i> Add Visit
                                    </p>
                                    <p><strong>Pet Type:</strong> {{petVisit.petType.name}}</p>
                                    <p><strong>Birth Date:</strong> {{petVisit.birthDate}}</p>
                                    <ul v-for="(visit) in petVisit.visits" :key="visit.id">
                                        <li>
                                            <p><strong>Visit Date:</strong> {{visit.date}}
                                                <i class="fa fa-pencil-square-o ml-2" aria-hidden="true" style="cursor: pointer" @click.prevent="editVisit(petVisit.id, visit.id)"></i>
                                            </p>
                                            <p><strong>Visit Description:</strong> {{visit.description}}</p>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </b-card-text>
                    </b-card>
                </b-card-group>
            </div>
        </div>
        <div class="row mt-2">
            <div class="col-md-2 col-sm-2 col-xs-2 mx-auto">
                <button class="btn btn-dark" @click.prevent="editOwner">Edit Owner</button>
            </div>
            <div class="col-md-2 col-sm-2 col-xs-2 mx-auto">
                <button class="btn btn-dark ml-2" @click.prevent="addPet">Add Pet</button>
            </div>
        </div>
    </div>
</template>

<script>
    import { mapGetters } from 'vuex';
    export default {
        name: "OwnerDetailView",
        computed: {
            ...mapGetters(['selectedOwner'])
        },
        methods: {
            editOwner() {
                this.$router.push({path: '/editOwner'});
            },
            addPet() {
                this.$router.push({path: '/addPet'});
            },
            editPet(id) {
                this.$router.push({path: '/editPet/' +id});
            },
            deletePet(id) {
                this.$store.dispatch('deletePet', id);
            },
            addVisit(id) {
                this.$router.push({path: '/addVisit/' +id});
            },
            editVisit(petId, visitId) {
                this.$router.push({path: '/editVisit/' +petId + '/' +visitId});
            }
        }
    }
</script>

<style scoped>

</style>