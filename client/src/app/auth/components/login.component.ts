import {Component} from '@angular/core';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'auth-login',
  imports: [RouterLink],
  template: `
    <div class="w-screen h-screen grid place-items-center p-4 select-none">
      <div class="bg-white rounded-3xl shadow-md p-10 w-full max-w-md border-t-4 border-teal-500 mt-[-2rem] fade-in-up">
        <div class="flex flex-col items-center">

          <div class="mb-6">
            <svg xmlns="http://www.w3.org/2000/svg" width="46" height="46" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
              <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z"/>
            </svg>
          </div>


          <!-- Welcome Text -->
          <h2 class="text-2xl font-semibold text-gray-800 mb-1">Welcome</h2>
          <p class="text-sm text-gray-500 mb-6">Sign in to continue</p>
        </div>

        <form class="space-y-5">
          <!-- Email -->
          <div>
            <label class="block text-gray-700 mb-1" for="username">Username</label>
            <input type="text" id="username" placeholder="Username"
                   class="w-full px-4 py-2 placeholder-gray-400 border border-gray-300 rounded-md focus:ring-2 focus:ring-teal-500 focus:outline-none" />
          </div>

          <!-- Password -->
          <div>
            <label class="block text-gray-700 mb-1" for="password">Password</label>
            <div class="relative">
              <input type="password" id="password" placeholder="Password"
                     class="w-full px-4 py-2 placeholder-gray-400 border border-gray-300 rounded-md focus:ring-2 focus:ring-teal-500 focus:outline-none pr-10" />
              <span class="absolute right-3 top-2.5 text-gray-400 cursor-pointer">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-fill mt-1" viewBox="0 0 16 16">
              <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0"/>
              <path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8m8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7"/>
            </svg>
          </span>
            </div>
          </div>

          <!-- Remember me and Forgot -->
          <div class="flex items-center justify-between text-sm">
            <label class="flex items-center gap-2">
              <input type="checkbox" class="accent-gray-600 hover:accent-teal-300" checked />
              <span class="text-gray-700 cursor-pointer">Remember me</span>
            </label>
            <a routerLink="/register" class="text-teal-500 hover:underline">Don't have an account?</a>
          </div>

          <!-- Sign In Button -->
          <button type="submit"
                  class="w-full bg-teal-500 hover:bg-teal-600 text-white py-2 rounded-md transition-colors cursor-pointer">
            Sign In
          </button>
        </form>
      </div>
    </div>
  `,
})
export class LoginComponent {}
