---
layout: page
title: ruthpohrp's Project Portfolio Page
---

### Project: DukePro(f)

DukePro(f) is a schedule-planning desktop application that assists university professors in managing their 
consultations. 
The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 42k Loc.

Given below are my contributions to the project.

* **New Feature**: Storing Blocked Slots Data
    * What it does: Stores list of blocked slots in the same .json file as consultation events
    * Justification: This feature improves the product significantly as users are likely to want to save 
      the data of the slots they've blocked previously rather than have to input it every time they open 
      the application.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2122s1.github.io/tp-dashboard/?search=ruthpohrp&sort=groupTitle&sortWithin=title&since=2021-09-17&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false)

* **Project management**:

* **Enhancements to existing features**: Remark field in Event model
    * What it does: Allow users to add and edit a new field called `remark` when adding and/or editing a
      consultation event
    * Justification: Users are likely to want to add details about their consultation events e.g. Contact
      details of their student.
    * Credit: Idea of the remark feature taken from AB-3 (though implemented differently).
  
* **Documentation**:
    * User Guide:
      * Wrote early format, structure, and documentation for the whole User Guide in general: 
        * Introduction, 
        * Purpose
        * Meaning of Icons and Textboxes
        * Quick Start
        * Command Summary
        * Commands and their Features
        * FAQ 
    * Developer Guide:
        * Added implementation details of the addition of the `remark` field.
        * Added implementation details of the addition of the Blocked Feature regarding Storage.
        * Added user stories and updated test cases for Appendix: Instructions for manual testing
    
* **Team-Based Tasks**:
    * Maintained issue tracker
    * Refactor `Phone` to `Date` 
    * Managed releases `v1.3(trial)` and `v1.3` on GitHub
