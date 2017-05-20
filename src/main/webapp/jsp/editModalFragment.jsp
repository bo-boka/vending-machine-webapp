<div class="modal fade" id="item-edit-modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    &times;
                </button>
            </div>
            <div class="modal-body">
                <h5 id="edit-item-id"></h5>
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="edit-item-name" class="col-md-4 control-label">Name:</label>
                        <div class="col-md-8">
                            <input id="edit-item-name" name="itemEditName" type="text" class="form-control" placeholder="Name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-item-cost" class="col-md-4 control-label">Cost:</label>
                        <div class="col-md-8">
                            <input id="edit-item-cost" name="itemEditCost" type="text" class="form-control" placeholder="0.00"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-item-inv" class="col-md-4 control-label">Stock:</label>
                        <div class="col-md-8">
                            <input id="edit-item-inv" name="itemEditInv" type="text" class="form-control" placeholder="0"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-item-img" class="col-md-4 control-label">Image url:</label>
                        <div class="col-md-8">
                            <input id="edit-item-img" name="itemEditImg" type="text" class="form-control" placeholder="http://..."/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-item-img" class="col-md-4 control-label">Dimensions:</label>
                        <div class="col-md-4">
                            Height: <input id="img-edit-height" name="imgEditHeight" type="text" class="form-control" placeholder="height"/>
                        </div>
                        <div class="col-md-4">
                            Width: <input id="img-edit-width" name="imgEditWidth" type="text" class="form-control" placeholder="width"/>
                        </div>
                    </div><br><br>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-4">
                            <button id="edit-button" class="btn btn-primary" data-dismiss="modal">Edit Item</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="close" data-dismiss="modal">
                    Close
                </button>
            </div>
        </div>
    </div>
</div>