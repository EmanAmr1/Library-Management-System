import { Gender } from "./gender";

export class User {

firstName!:string;
lastName!:string;
userName!:string;
 password!:string;
 gender!:Gender;
role!:{
id:number,
roleName:string
}
}
