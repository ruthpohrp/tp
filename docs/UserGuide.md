---
layout: page
title: User Guide
---

DukePro(f) helps **professors in a university** plan their engagements. Amid long days of lectures and 
tutorials, it is hard to properly fit in **consultations** with students and keep track of them at the same 
time. With DukePro(f), profs can easily query their available time slots and save their engagements, making lesson-planning a breeze.

## Table of Contents
- [1. Command summary](#1-command-summary)
- [2. Quick Start](#2-quick-start)
- [3. Features](#3-features)
    * [3.1 Adding a person: `add`](#31-adding-a-person---add-)
    * [3.2 Listing All Consults: `list_consults`](#32-listing-all-consults---list-consults-)
    * [3.3 Listing All Open Slots: `list_slots`](#33-listing-all-open-slots---list-slots-)
    * [3.4 Deleting a Consultation Event: `delete`](#34-deleting-a-consultation-event---delete-)
    * [3.5 Saving all edits : `save`](#35-saving-all-edits----save-)
    * [3.6 Exiting the app : `exit`](#36-exiting-the-app----exit-)
- [4. FAQ](#4-faq)

***
## 1. Command summary
***
Action | Format, Examples
--------|------------------
**Add** | `add n/NAME d/DATE t/TIME m/MODULE` <br> e.g., `add n/Lulu Yousef d/2021-09-01 t/1300 m/CS2103T`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**List** | `list_consults`
**List Slots** | `list_slots`
**Save** | `save`
**Exit** | `exit`

***
## 2. Quick Start
***
1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `dukeprof.jar` from [here](https://github.com/AY2122S1-CS2103T-T11-4/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your DukePro(f).

4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. 
   Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing 
   Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all contacts.

   * **`add`**`add n/Lulu Yousef d/2021-09-01 t/1300 m/CS2103T` : Adds a contact named `Lulu Yousef` to the Address Book.

   * **`delete`**`3` : Deletes the 3rd contact shown in the current list.
    
   * **`exit`** : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

***
## 3. Features
***
<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/Lulu Yousef`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME d/DATE`, `d/DATE n/NAME` is also acceptable.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `m/CS2103T m/CS2101`, only `m/CS2101` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `list` and `exit`) will be 
  ignored.<br>
  e.g. if the command specifies `list 123`, it will be interpreted as `list`.

</div>

### 3.1 Adding a person: `add`

Adds a person to Dukepro(f).

Format: `add n/NAME d/DATE t/TIME m/MODULE`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:
* `add n/Lulu Yousef d/2021-09-01 t/1300 m/CS2103T`

### 3.2 Listing All Consults: `list_consults`
Lists down all consults scheduled.

Format: `list_consults`

Expected output:
```
Name: Lulu Yousef; Date: 2021-09-01; Time: 1300; Module: CS2103T
Name: Quan Teng Foong; Date: 2021-09-02; Time: 1000; Module: CS2103
```
### 3.3 Listing All Open Slots: `list_slots`
Lists down all the open slots within the next week.

Format: ` list_slots`

Expected output:
```
        Date: 2021-09-01
		Available slots: 1000, 1100, 1400, 1500
	Date: 2021-09-02
		Available slots: 1100, 1300, 1400, 1500
	Date: 2021-09-03
		Available slots: 1000, 1100, 1300, 1400, 1500
	Date: 2021-09-04
		WEEKEND
	Date: 2021-09-05
		WEEKEND
	Date: 2021-09-06
		Available slots: 1000, 1100, 1300, 1400, 1500
	Date: 2021-09-07
		Available slots: 1000, 1100, 1300, 1400, 1500
```

### 3.4 Deleting a Consultation Event: `delete`

Deletes a consult event from the timetable. Indexed according to the result of the ‘list’ command (see below).

Format: `delete INDEX`

Example: `delete 1`

### 3.5 Saving all edits : `save`
Saves all edits made.

Format: `save`

### 3.6 Exiting the app : `exit`
Exits the application.

Format: `exit`

***
## 4. FAQ
***
**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.
