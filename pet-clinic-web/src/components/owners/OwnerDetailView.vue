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
                            <ul v-for="(petVisit, index) in selectedOwner.pets" :key="index">
                                <li>
                                    <p><strong>Pet Name:</strong> {{petVisit.name}}</p>
                                    <p><strong>Pet Type:</strong> {{petVisit.petType.name}}</p>
                                    <p><strong>Birth Date:</strong> {{petVisit.birthDate}}</p>
                                    <ul v-for="(visit, visitIndex) in petVisit.visits" :key="visitIndex">
                                        <li>
                                            <p><strong>Visit Date:</strong> {{visit.date}}</p>
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
            }
        }
    }
</script>

<style scoped>

</style>