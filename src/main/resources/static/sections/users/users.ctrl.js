'use strict';


angular.module('app').controller('UserController', function ($scope, users, PageValues) {
    var vm = this;    

    vm.submit=function(e){
        ev.target.checkValidity();
        return false;
    }



    vm.init=function(){    
        if(users && users.length>0){
            angular.forEach(users, function(value, key){
                if(value && value.id){

                }   
                value.editbtn='<a href="#/user/edit" class="btn btn-default active">Edit</a>';
                value.deletebtn='<button type="button" class="btn btn-danger active">Delete</button>';                
             });
            $('#user-list-tbl').dataTable({
                "aaData": users,
                "aoColumns": [
                    { "mDataProp": "name" },
                    { "mDataProp": "email" },
                    { "mDataProp": "mobile" },
                    { "mDataProp": "country" },            
                    { "mDataProp": "role" },            
                    { "mDataProp": "createBy" },            
                    { "mDataProp": "editbtn" },            
                    { "mDataProp": "deletebtn" }            
                ]
            });
        }
    }
});

angular.module('app').controller('createUserController', function ($scope) {
    var vm = this;
});

angular.module('app').controller('updateUserController', function ($scope) {
    var vm = this;
});