//---------------------------ALERTAS DE CANCIÓN------------------------//
function deleteC(idCancion) {
    let id=idCancion;
    Swal.fire({
        title: '¿Está usted seguro?',
        text: "No podrás revertir el cambio",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si, ¡borrelo!'
      }).then((result) => {
        if (result.isConfirmed) {
          Swal.fire(
            '¡Borrado!',
            'Your file has been deleted.',
            'success'

          )
          window.location.href=`delete/${id}`
          }// }{/cancion/editar/}
      })
}

function editarC(idCancion) {
  let id=idCancion;
  Swal.fire({
    title: '¿Está usted seguro?',
    text: "EDITAR",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Si, ¡editalo!'
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire(
        '¡editado!',
      )
      window.location.href=`editar/${id}`
      }
  })
}
//---------------------------ALERTAS DE DISQUERA------------------------//
function editarD(idDisquera) {
  let id=idDisquera;
  Swal.fire({
    title: '¿Está usted seguro?',
    text: "EDITAR",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Si, ¡editalo!'
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire(
        '¡editado!',
      )
      window.location.href=`editar/${id}`
      }
  })
}

function deleteD(idDisquera) {
  let id=idDisquera;
  Swal.fire({
      title: '¿Está usted seguro?',
      text: "No podrás revertir el cambio",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, ¡borrelo!'
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire(
          '¡Borrado!',
          'Your file has been deleted.',
          'success'

        )
        window.location.href=`delete/${id}`
        }// }{/cancion/editar/}
    })
}

//---------------------------ALERTAS DE DISQUERA------------------------//
function editarA(idArtista) {
  let id=idArtista;
  Swal.fire({
    title: '¿Está usted seguro?',
    text: "EDITAR",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Si, ¡editalo!'
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire(
        '¡editado!',
      )
      window.location.href=`editar/${id}`
      }
  })
}

function deleteA(idArtista) {
  let id=idArtista;
  Swal.fire({
      title: '¿Está usted seguro?',
      text: "No podrás revertir el cambio",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, ¡borrelo!'
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire(
          '¡Borrado!',
          'Your file has been deleted.',
          'success'

        )
        window.location.href=`delete/${id}`
        }// }{/cancion/editar/}
    })
}
