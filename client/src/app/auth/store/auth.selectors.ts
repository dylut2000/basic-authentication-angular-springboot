import * as fromAuth from './auth.reducer';
import {createFeatureSelector, createSelector} from '@ngrx/store';
import {AuthStateType} from '../model/auth.model';

// CREATE FEATURE SELECTOR

export const selectAuthState = createFeatureSelector<AuthStateType>(fromAuth.authFeatureKey);

// STATE KEYS SELECTORS

export const selectUser = createSelector(selectAuthState, (state: AuthStateType) => state.user);

export const selectToken = createSelector(selectAuthState, (state: AuthStateType) => state.token);

export const selectIsLoggedIn = createSelector(selectAuthState, (state: AuthStateType) => state.isLoggedIn);

export const selectError = createSelector(selectAuthState, (state: AuthStateType) => state.error);

export const selectLoading = createSelector(selectAuthState, (state: AuthStateType) => state.loading);

// SELECTOR USER KEYS (Not really important, just to show that you can create a selector from other selectors)

export const selectUserId = createSelector(selectUser, (user) => user?.id);

export const selectUserRole = createSelector(selectUser, (user) => user?.role);

export const selectUserName = createSelector(selectUser, (user) => user?.username)
