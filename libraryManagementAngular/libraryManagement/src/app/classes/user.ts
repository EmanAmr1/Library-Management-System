import { Gender } from "./gender";

export class User {

firstName!:string;
lastName!:string;
userName!:string;
 password!:string;
 enabled!:boolean;
 verificationCode!:string;
 email!:string;
 gender!:Gender;
role!:{
id:number,
roleName:string
}
}
