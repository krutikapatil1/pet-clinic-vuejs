<template>
    <b-table hover striped :fields="fields" :items="ownersSearchResults" style="cursor:pointer;" @row-clicked="rowSelected"></b-table>
</template>

<script>
    import { mapGetters } from 'vuex';
    export default {
        name: "OwnerListView",
        data() {
            return {
                fields: ['firstName', 'lastName', 'address', 'city', 'telephone']
            }
        },
        computed: {
            ...mapGetters(['ownersSearchResults'])
        },
        methods: {
            rowSelected(row) {
                this.$store.dispatch('setSelectedOwner', row);
            }
        }
    }
</script>

<style scoped>

</style>