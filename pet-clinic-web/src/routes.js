import Vets from './components/Vets.vue';
import Home from './components/Home.vue';
import Owners from './components/owners/Owners.vue';
import OwnerStartView from "./components/owners/OwnerStartView.vue";
import OwnerListView from "./components/owners/OwnerListView.vue";
import OwnerDetailView from "./components/owners/OwnerDetailView.vue";
import AddOwner from "./components/owners/AddOwner.vue";
import EditOwner from "./components/owners/EditOwner.vue";
import AddPet from "./components/owners/AddPet.vue";
import EditPet from "./components/owners/EditPet.vue";
import Error from './components/common/Error.vue';

export const routes = [
    {path: '/', component: Home, name: Home},
    {path: '/vets', component: Vets, name: Vets},
    {path: '/owners', component: Owners, name: Owners, children: [
            {path: '', component: OwnerStartView, name: OwnerStartView},
            {path: 'listView', component: OwnerListView, name: OwnerListView},
            {path: 'detailView', component: OwnerDetailView, name: OwnerDetailView}
        ]},
    {path: '/addOwner', component: AddOwner, name: AddOwner},
    {path: '/editOwner', component: EditOwner, name: EditOwner},
    {path: '/addPet', component: AddPet, name: AddPet},
    {path: '/editPet/:id', component: EditPet, name: EditPet},
    {path: '/error', component: Error, name: Error}
]