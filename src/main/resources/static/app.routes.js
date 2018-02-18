'use strict';

angular
    .module('app.routes', ['ngRoute'])
    .config(config);

function config($routeProvider) {
    $routeProvider.
    /* home section */
    when('/', {
            templateUrl: 'sections/home/home.tpl.html',
            controller: 'HomeController as home'
        })
        .when('/home', {
            templateUrl: 'sections/home/home.tpl.html',
            controller: 'HomeController as home'
        })

        /* workflow section */
        .when('/entries/new', {
            templateUrl: 'sections/entries/new.tpl.html',
            controller: 'NewEntryController as entry'
        })
        .when('/entries/duplicate', {
            templateUrl: 'sections/entries/duplicate.tpl.html',
            controller: 'DuplicateEntryController as entry'
        })
        .when('/entries/create', {
            templateUrl: 'sections/entries/create.tpl.html',
            controller: 'CreateEntryController as entry'
        })
        .when('/initiate', {
            templateUrl: 'sections/workflow/new.form.tpl.html',
            controller: 'CreateWorkflowController as workflow'
        })
        .when('/download', {
            templateUrl: 'sections/workflow/export.tpl.html',
            controller: 'ExportWorkflowController as workflow'
        })
        .when('/flow/list/:name', {
            templateUrl: 'sections/workflow/export.tpl.html',
            controller: 'ListWorkflowController as workflow',
            resolve: {
                show: function (worklowService, $route) {
                    return worklowService.getList($route.current.params.name);
                }
            }
        })
        .when('/flow/view/:id', {
            templateUrl: 'sections/workflow/create.tpl.html',
            controller: 'ViewWorkflowController as workflow',
            resolve: {
                show: function (worklowService, $route) {
                    return worklowService.getDetails($route.current.params.id);
                }
            }
        })
        /* user section */
        .when('/users', {
            templateUrl: 'sections/users/list.tpl.html',
            controller: 'UserController as user',
            resolve: {
                users: function (userService) {
                    return userService.getUsers();
                }
            }
        })
        .when('/user/create', {
            templateUrl: 'sections/users/new.tpl.html',
            controller: 'createUserController as user'
        })
        .when('/user/edit', {
            templateUrl: 'sections/users/new.tpl.html',
            controller: 'createUserController as user'
        })
        /* other section */
        .when('/view/:id', {
            templateUrl: 'sections/view/view.tpl.html',
            controller: 'ViewController as view',
            resolve: {
                show: function (ShowService, $route) {
                    return ShowService.get($route.current.params.id);
                }
            }
        })
        .otherwise({
            templateUrl: 'sections/error/404.tpl.html'
            //redirectTo: '/'
        });
}