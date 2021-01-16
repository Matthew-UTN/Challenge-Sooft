<template>
    <div>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <b-table 
        show-empty
        responsive="sm"
        
        :items="users"
        :fields="fields"> <!--Armo la tabla-->
        

        <template v-slot:cell(actions)="row"><!--Esto hace una columna que se llama accion que tiene modificar y eliminar-->
            <b-button style="margin-left: 10px" @click="eliminar(row)"><md-icon class="fa fa-trash"></md-icon></b-button>
        </template>

      
    </b-table>
    
        
    </div>
</template>

<script>



export default {
    name: 'Tabla',
    components:{
    },
    methods:{
      eliminar(row){ 
        this.confirmar = ''
        this.$bvModal.msgBoxConfirm('Estas seguro que quieres eliminar esta reserva?', {
          title: 'Confirmar',
          size: 'sm',
          buttonSize: 'sm',
          okVariant: 'danger',
          okTitle: 'SI',
          cancelTitle: 'NO',
          footerClass: 'p-2',
          hideHeaderClose: false,
          centered: true
        })
          .then(value => {
            this.confirmar = value
            console.log(row.item.nombre)
            console.log(row.item.apellido)
            
            const msg = 'Se borro exitosamente';
            this.success(msg);
          })
          .catch(err => {
            console.log(err)
            console.log(row)// An error occurred
          })
          
          this.$forceUpdate();
      },success(msg) { // pop up de que se subio exitosamente
      this.boxTwo = ''
      this.$bvModal.msgBoxOk(msg, {
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
    },
    data: () => ({
      users: [
        {
          id: 1,
          nombre: "Alvarado, Eduardo Alfonso",
          start: "2019-03-1 10:00",
          end: "2019-03-1 10:30",
          horario: "de 10:00 a 10:30"
        },
        {
          id: 2,
          nombre: "Acuña López, Juliana",
          start: "2019-03-1 11:00",
          end: "2019-03-1 11:45",
          horario: "de 11:00 a 11:45"
        }
      ],
      fields: [
          {
            key: 'nombre',
            label: 'Nombre'
          },
          {
            key: 'horario',
            label:'Horario',
            sortable: true
          },
          { key: 'actions', label: 'Opciones'}
        ]
    })
    
}
</script>
<style>
#Header{
    color:rgb(16, 148, 44);
    text-align-last: justify;
    text-indent: 2%;
    font-family: Avenir, Helvetica, Arial, sans-serif;
}
#Nombre{
    text-align-last: justify;
    color: chocolate;
    text-indent: 2%;
    font-family: Avenir, Helvetica, Arial, sans-serif;
}
</style>