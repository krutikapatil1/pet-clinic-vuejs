import Vets from './components/Vets.vue';
import Home from './components/Home.vue';
import Owners from './components/Owners.vue';

export const routes = [
    {path: '/', component: Home, name: Home},
    {path: '/vets', component: Vets, name: Vets},
    {path: '/owners', component: Owners, name: Owners}
]