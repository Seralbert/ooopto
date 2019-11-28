<div class="modal fade" id="modalFrame" tabindex="-1" role="dialog" aria-labelledby="modalCenterTitle"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <form id="modalFrame" action="doAddDoc" method="post" enctype="multipart/form-data">
            <div class="modal-header">
                <h5 class="modal-title" id="ModalTitle" style="color: #1b1e21;">Добавить образ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">

                    <div class="form-group">
                        <label for="firstInputLineModalWindow">Example label</label>
                        <input type="text" class="form-control" id="firstInputLineModalWindow"
                               placeholder="Описание образа" name="fileDescription">
                    </div>
                    <div class="form-group">
                        <label for="secondInputLineModalWindow">Another label</label>
                        <input type="file" class="form-control" id="secondInputLineModalWindow"
                               placeholder="Another input" name="file">
                    </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <input type="submit" class="btn btn-primary" />
            </div>
            </form>
        </div>
    </div>
</div>