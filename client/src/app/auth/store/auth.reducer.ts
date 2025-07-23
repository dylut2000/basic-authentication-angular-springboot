import {AuthStateType} from '../model/auth.model';
import {createReducer, on} from '@ngrx/store';
import * as AuthActions from './auth.actions'


export const authFeatureKey = 'auth';

export const initialState: AuthStateType = {
  user: null,
  token: null,
  loading: false,
  isLoggedIn: false,
  error: null
};

export const authReducer = createReducer(
  initialState,
  on(AuthActions.REGISTER, (state) => ({
    ...state,
    loading: true
  })),

  on(AuthActions.REGISTER_SUCCESS, (state, payload) => ({
    ...state,
    user: payload.data,
    loading: false
  })),

  on(AuthActions.REGISTER_FAILURE, (state, payload) => ({
    ...state,
    loading: false,
    error: payload.error || 'Failed to register',
  })),

  on(AuthActions.LOGIN, (state) => ({
    ...state,
    loading: true
  })),

  on(AuthActions.LOGIN_SUCCESS, (state, payload) => ({
    ...state,
    user: payload.data.user,
    token: payload.data.token,
    loading: false,
    isLoggedIn: true
  })),

  on(AuthActions.LOGIN_FAILURE, (state, payload) => ({
    ...state,
    loading: false,
    error: payload.error || 'Failed to authenticate',
  })),

  on(AuthActions.LOGOUT, (state) => ({
    ...initialState,
  }))

)
