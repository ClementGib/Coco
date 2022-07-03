import { ComponentFixture, TestBed } from "@angular/core/testing";
import { By } from "@angular/platform-browser";
import { RouterTestingModule } from "@angular/router/testing";
import { SubNavbarComponent } from "./sub-navbar.component";

describe('SubNavbarComponent', () => {
    let fixture: ComponentFixture<SubNavbarComponent>;
    let component: SubNavbarComponent;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            imports: [RouterTestingModule],
            declarations: [
                SubNavbarComponent
            ]
        }).compileComponents();
    });

    beforeEach(() => {
        fixture = TestBed.createComponent(SubNavbarComponent);
        component = fixture.componentInstance;
    });

    describe('Should correctly initialize sub navbar', () => {
        it('When initialize app it should create the component', () => {
            const fixture = TestBed.createComponent(SubNavbarComponent);
            const app = fixture.componentInstance;

            expect(app).toBeTruthy();
        });
    });

    describe('Should correctly initialize sub navigation', () => {
        it('When initialize app it should create sub navgation links', () => {
            fixture.detectChanges();
            const subNavbarRows = fixture.debugElement.queryAll(By.css('.container-subnavbar'));

            expect(subNavbarRows[0].children.length).toEqual(3);
        });

        describe('Should display each link', () => {

            it('When initialize app it should create all courses link', () => {
                fixture.detectChanges();
                const allCoursesRows = fixture.debugElement.queryAll(By.css('.allcours-subnavbar'));

                expect(allCoursesRows[0].children[0].nativeElement.getAttribute('href')).toEqual('/courses/all');
            });

            it('When initialize app it should create all courses link', () => {
                fixture.detectChanges();
                const allCoursesRows = fixture.debugElement.queryAll(By.css('.mycours-subnavbar'));

                expect(allCoursesRows[0].children[0].nativeElement.getAttribute('href')).toEqual('/courses');
            });

            it('When initialize app it should create all courses link', () => {
                fixture.detectChanges();
                const allCoursesRows = fixture.debugElement.queryAll(By.css('.suggestion-subnavbar'));

                expect(allCoursesRows[0].children[0].nativeElement.getAttribute('href')).toEqual('/courses/suggestion');
            });
        });
    });
});
