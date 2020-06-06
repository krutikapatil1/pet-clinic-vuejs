<template>
    <div>
        <b-navbar toggleable="lg" type="dark" variant="dark">
            <b-navbar-brand to="/">
                <img src="../../assets/spring-logo-dataflow-mobile.png" alt="Kitten">
            </b-navbar-brand>

            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

            <b-collapse id="nav-collapse" is-nav>
                <b-navbar-nav class="mx-auto">
                    <b-nav-item to="/" active-class="active"><i class="fa fa-home"></i> HOME</b-nav-item>
                    <b-nav-item to="/owners" active-class="active"><i class="fa fa-search"></i> FIND OWNERS</b-nav-item>
                    <b-nav-item to="/vets" active-class="active"><i class="fa fa-th-list"></i> VETERINARIANS</b-nav-item>
                    <b-nav-item to="/error" active-class="active"><i class="fa fa-exclamation-triangle"></i> ERROR</b-nav-item>
                </b-navbar-nav>
            </b-collapse>
        </b-navbar>
    </div>
</template>
<style scoped>

</style>
