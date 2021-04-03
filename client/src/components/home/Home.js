// ANCHOR Home page of the App

import React from 'react'
import Header from '../layout/Header'
import Footer from '../layout/Footer'


import Courses from './Courses'
import MyCourses from './MyCourses'
import Suggestion from './Suggestions'


export default function Home() {
    return (
        <div>
            <Header/>
            <MyCourses/>
            <Footer/>
        </div>
    )
}
