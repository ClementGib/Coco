import { ButtonUnderlineComponent } from "./button-underline/button-underline.component";
import { FooterComponent } from "./footer/footer.component";
import { HeaderComponent } from "./header/components/header.component";
import { MainNavbarComponent } from "./header/components/main-navbar/main-navbar.component";
import { SubNavbarComponent } from "./header/components/sub-navbar/sub-navbar.component";

export const declarationComponents: any[] = [HeaderComponent, MainNavbarComponent, SubNavbarComponent, FooterComponent, ButtonUnderlineComponent];
export const exportComponents : any[] = [HeaderComponent, FooterComponent, ButtonUnderlineComponent];

export * from "./button-underline/button-underline.component";