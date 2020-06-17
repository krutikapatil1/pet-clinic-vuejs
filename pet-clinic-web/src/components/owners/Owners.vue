<template>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12">
                <br>
                <h3>Search Owners</h3>
                <br>
<!--                <b-table striped hover head-variant="dark" :items="owners"></b-table>-->
<!--                <alert class="alert alert-warning">Not Implemented Yet!!</alert>-->
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
                    <button class="btn btn-primary" @click.prevent="searchOwners" :disabled="lastName == ''">Find Owners</button>
                </b-form>
            </div>
        </div>
        <div v-if="searchResults.length > 0">
            <div class="row mt-5" v-if="showListView">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <b-table hover striped :items="items" :fields="fields" @row-clicked="expandRow" style="cursor: pointer"></b-table>
                </div>
            </div>
            <div class="mt-5" v-else>
                <div class="row">
                    <div class="col-md-6 col-sm-6 col-xs-6">
                        <b-card
                                border-variant="success"
                                header-bg-variant="success"
                                header-text-variant="white"
                                header="Owner Information"
                                header-tag="header"
                            >
                            <b-card-text>
                                <div class="row">
                                    <div class="col-md-6 col-xs-6 col-sm-6">
                                        <h6>Name</h6>
                                    </div>
                                    <div class="col-md-6 col-xs-6 col-sm-6">
                                        <p>{{selectedOwner.name}}</p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 col-xs-6 col-sm-6">
                                        <h6>Address</h6>
                                    </div>
                                    <div class="col-md-6 col-xs-6 col-sm-6">
                                        <p>{{selectedOwner.address}}</p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 col-xs-6 col-sm-6">
                                        <h6>City</h6>
                                    </div>
                                    <div class="col-md-6 col-xs-6 col-sm-6">
                                        <p>{{selectedOwner.city}}</p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 col-xs-6 col-sm-6">
                                        <h6>Telephone</h6>
                                    </div>
                                    <div class="col-md-6 col-xs-6 col-sm-6">
                                        <p>{{selectedOwner.telephone}}</p>
                                    </div>
                                </div>
                            </b-card-text>
                        </b-card>
                    </div>
                    <div class="col-md-6 col-sm-6 col-xs-6">
                        <b-card
                                border-variant="success"
                                header-bg-variant="success"
                                header-text-variant="white"
                                header="Pets and Visits"
                                header-tag="header"
                        >
                            <b-text>
                                <div class="row">
                                    <div class="col-md-12 col-xs-12 col-sm-12">
                                        <ul v-for="(petVisit, index) in selectedOwnerPetVisitInfo" :key="index">
                                            <li>
                                                <div>
                                                    <p><strong>Name:</strong> {{petVisit.name}}</p>
                                                    <p><strong>Type:</strong> {{petVisit.type}}</p>
                                                    <p><strong>Birth Date:</strong> {{petVisit.birthDate}}</p>
                                                </div>
                                            </li>
                                            <ul v-for="(visit, visitIndex) in petVisit.visits" :key="visitIndex">
                                                <li>
                                                    <div>
                                                        <p><strong>Visit Date:</strong> {{visit.visitDate}}</p>
                                                        <p><strong>Visit Description:</strong> {{visit.visitDescription}}</p>
                                                    </div>
                                                </li>
                                            </ul>
                                        </ul>
                                    </div>
                                 </div>
                            </b-text>
                        </b-card>
                    </div>
                </div>
                <div class="row mt-4">
                    <div class="col-md-3 col-sm-3 col-xs-3 mx-auto">
                        <button class="btn btn-danger">Edit Owner</button>
                        <button class="btn btn-primary ml-2">Add New Pet</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    import axios from 'axios';
    export default {
        data() {
            return {
                lastName: '',
                searchResults: [],
                items: [],
                fields: [ 'name', 'address', 'city', 'telephone', 'pets'],
                showListView: false,
                selectedOwner: {},
                selectedOwnerPetVisitInfo: [],
                showError: false
            }
        },
        methods: {
            searchOwners() {
                axios.get('/owners/findAllByLastNameLike/' +this.lastName).then(res => {
                    console.log(res.data);
                    this.searchResults = res.data;
                    if (this.searchResults.length == 0) {
                        this.showError = true;
                    }
                    else {
                        this.showError = false;
                    }
                    this.assembleResults();
                    if (this.searchResults.length > 1) {
                        this.showListView = true;
                    }
                    else if (this.searchResults.length == 1) {
                        this.searchResults.forEach(result => {
                            this.selectedOwner.id = result.id;
                            this.selectedOwner.name = result.firstName + ' ' +result.lastName;
                            this.selectedOwner.address = result.address;
                            this.selectedOwner.city = result.city;
                            this.selectedOwner.telephone = result.telephone;
                        });
                        this.loadSelectedOwnerPetsAndVisits();
                        this.showListView = false;
                    }
                }).catch(error => {
                    console.log(error);
                })
            },
            assembleResults() {
                this.items = [];
                this.searchResults.forEach(item => {
                    let pets = '';
                    let addItem = {};
                    addItem.id = item.id;
                    addItem.name = item.firstName + ' ' + item.lastName;
                    addItem.address = item.address;
                    addItem.city = item.city;
                    addItem.telephone = item.telephone;
                    item.pets.forEach(pet => {
                        if (pets !== '') {
                            pets = pets + ', ';
                        }
                        pets = pets + pet.name;
                    })
                    addItem.pets = pets;
                    this.items.push(addItem);
                })
            },
            expandRow(row) {
                this.selectedOwner = row;
                this.loadSelectedOwnerPetsAndVisits();
                this.showListView = false;
            },
            loadSelectedOwnerPetsAndVisits() {
                let fullDetails = this.searchResults.find(owner => owner.id === this.selectedOwner.id);
                console.log(fullDetails);
                this.selectedOwnerPetVisitInfo = [];
                fullDetails.pets.forEach(pet => {
                    let petVisitItem = {};
                    petVisitItem.name = pet.name;
                    petVisitItem.birthDate = pet.birthDate;
                    petVisitItem.type = pet.petType.name;
                    petVisitItem.visits = [];
                    pet.visits.forEach(visit => {
                        let visitItem = {};
                        visitItem.visitDate = visit.date;
                        visitItem.visitDescription = visit.description;
                        petVisitItem.visits.push(visitItem);
                    });
                    this.selectedOwnerPetVisitInfo.push(petVisitItem);
                })
            }
        }
    }
</script>