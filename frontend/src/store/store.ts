import {configureStore } from '@reduxjs/toolkit'
import carAllSlice from './carAllSlice'

export const store =configureStore({
reducer:{
  carAllList: carAllSlice

}

})

