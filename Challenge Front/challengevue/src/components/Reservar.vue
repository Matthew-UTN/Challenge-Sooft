<template>
    <div>
            
        <b-card >
            <b-card-text id="Header">
            <b>RESERVAR</b>
            </b-card-text>

            <b-form inline @submit="onSubmit">
                <div class="form-group col-sm-6">
                    <label for="text-password" id="Title" >Nombre</label>
                    <b-form-input type="text" id="text-nombre" style="width:100%" v-model="form.nombre" required></b-form-input>
                </div>
                <div class="form-group col-sm-2">
                    <label for="text-password" id="Title" >Fecha</label>
                    <b-form-datepicker id="fecha" v-model="form.fecha" style="width:100%"></b-form-datepicker>
                </div>
                <div class="form-group col-sm-3">
                    <div class="form-group col-sm-6">
                        <label for="text-password" id="Title" >Desde</label>
                        <b-form-timepicker v-model="form.desde" locale="en" placeholder="12:00" style="width:100%"></b-form-timepicker>
                    </div>
                    <div class="form-group col-sm-6">
                        <label for="text-password" id="Title" >Hasta</label>
                        <b-form-timepicker v-model="form.hasta" locale="en" placeholder="13:00" style="width:100%"></b-form-timepicker>
                    </div>
                </div>
                
                <div class="form-group col-sm-1" style="margin-top:1.4%">
                    <button type="submit" class="btn btn-primary" style="width:100%" >Guardar</button>
                </div>
       
            </b-form>
        </b-card>

    </div>
    
</template>

<script>


export default {

    name: 'Reservar',

  data() {
    return {
      form: {
          nombre: '',
          fecha: '',
          desde: '',
          hasta: '',
        },
        
    }
  },
  methods: {
    async onSubmit(evt) {
        evt.preventDefault()
        console.log(this.form);
        
        
    },
    success() { // pop up de que se subio exitosamente
      this.boxTwo = ''
      this.$bvModal.msgBoxOk('Los datos se subieron exitosamente', {
        title: 'Confirmacion',
        size: 'sm',
        buttonSize: 'sm',
        okVariant: 'success',
        headerClass: 'p-2 border-bottom-0',
        footerClass: 'p-2 border-top-0',
        centered: true
      })
      .then(value => {
          this.boxTwo = value
        })
        .catch(err => {
          console.log(err)// An error occurred
        })
      }
  }
};
</script>
<style>
#Header{
    color:rgb(16, 148, 44);
    font-size:30px;
    margin-right: 60%;
    font-family: Avenir, Helvetica, Arial, sans-serif;
}
#Title{
    margin-right: 93%;
    font-family: Avenir, Helvetica, Arial, sans-serif;
}

</style>