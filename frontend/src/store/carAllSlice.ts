import{createAsyncThunk,createSlice} from '@reduxjs/toolkit'

const initialState={
carAllList:[]
}

export const getAllCar=createAsyncThunk('car',async()=>{
const response =await fetch('http://localhost:8080/api/cars/getAll')
const data = response.json();
return data;

})



const carAllSlice = createSlice({
    name: "carAllList",
    initialState,
    reducers: {},
   extraReducers(builder) {
       
   },
})

export default carAllSlice.reducer;