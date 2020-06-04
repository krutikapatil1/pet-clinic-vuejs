<template>
    <div>
        <b-navbar toggleable="lg" type="dark" variant="success">
            <b-navbar-brand to="/">Home</b-navbar-brand>

            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

            <b-collapse id="nav-collapse" is-nav>
                <b-navbar-nav>
                    <b-nav-item to="/vets" active-class="active">Vets</b-nav-item>
                </b-navbar-nav>
            </b-collapse>
        </b-navbar>
    </div>
</template>
