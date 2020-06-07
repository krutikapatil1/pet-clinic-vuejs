import Vets from './components/Vets.vue';
import Home from './components/Home.vue';
import Owners from './components/Owners.vue';
import Error from './components/common/Error.vue';

export const routes = [
    {path: '/', component: Home, name: Home},
    {path: '/vets', component: Vets, name: Vets},
    {path: '/owners', component: Owners, name: Owners},
    {path: '/error', component: Error, name: Error}
]