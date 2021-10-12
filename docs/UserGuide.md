---
layout: page
title: User Guide
---

DukePro(f) helps **professors in a university** plan their engagements. Amid long days of lectures and 
tutorials, it is hard to properly fit in **consultations** with students and keep track of them at the same 
time. With DukePro(f), profs can easily query their available time slots and save their engagements, making lesson-planning a breeze.

## Table of Contents

* TOC
{:toc}

***
## 1. Command Summary
***

Action | Format | Examples
--------|-------|-------
**Add** | `add n/NAME d/DATE t/TIME l/LOCATION [tag/TAG]...` | `add n/Lulu Yousef d/2020-01-01 t/0800 l/NUS tag/Important tag/Supplementary`
**Clear** | `clear`  | -
**Delete** | `delete INDEX` | `delete 3`
**Edit** | `edit INDEX [n/NAME] [d/DATE] [t/TIME] [l/LOCATION] [tag/TAG]...`  | `edit 2 n/Quan Teng Foong` <br> `edit 6 tag/Zoom Meeting`
**Find** | `find KEYWORD`  | `find Teng Foong`
**Help** | `help` | -
**List** | `list` | -
**Exit** | `exit` | -


## 2. Quick Start
***
1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `dukeprof.jar` from [here](https://github.com/AY2122S1-CS2103T-T11-4/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your DukePro(f).

4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. 
   Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)
   <!-- will need to change Ui.png once GUI is updated.-->

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing 
   Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all contacts.

   * **`add`**`add n/Lulu Yousef d/2021-09-01 t/1300 m/CS2103T` : Adds a contact named `Lulu Yousef` to the Address Book.

   * **`delete`**`3` : Deletes the 3rd contact shown in the current list.
    

6. Refer to the [Features](#features) below for details of each command.


## 3. Features
***
<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  * e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/Lulu Yousef`.

* Items in square brackets are optional.
  * e.g. `[tag/TAG]` is an optional parameter.

* Parameters can have more than one entry will be anteceded by a `...`
  * e.g. `[tag/TAG]...` can have more than one entry, so `tag/supplmentary tag/important` is accepted.

* Parameters can be in any order.<br>
  * e.g. if the command specifies `n/NAME d/DATE`, `d/DATE n/NAME` is also acceptable.

* If a parameter is expected only once in the command, but you have specified it multiple times, only the 
  last occurrence of the parameter will be taken.<br>
  * e.g. if you specify `t/0100 t/2359`, only `t/2359` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `list` and `exit`) will be 
  ignored.<br>
  * e.g. if the command specifies `list 123`, it will be interpreted as `list`.

</div>

### 3.1 Adding a Consultation Event : `add`

Adds an event to Dukepro(f).

Format: `add n/NAME d/DATE t/TIME l/LOCATION [tag/TAG]...`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
An event can have any number of tags (including 0).
</div>

Examples:
* `add n/Lulu Yousef d/2020-01-01 t/0800 l/NUS tag/Important tag/Supplementary`

### 3.2 Clearing all Consultation Events : `clear`

Clears all consultation events stored in DukePro(f).

<div markdown="span" class="alert alert-danger">:warning: **WARNING**: This command cannot be reversed. Be 
careful when using this command!
</div>

Format: `clear`


### 3.3 Deleting a Consultation Event : `delete`

Deletes a consult event from DukePro(f). Indexed according to the result of the ‘list’ command (see below).

Format: `delete INDEX`

Example: `delete 1`

### 3.4 Editing a Consultation Event : `edit`

Edits the details of a consult event from DukePro(f). Indexed according to the result of the 'list' command(see below).

Format: `edit INDEX [n/NAME] [d/DATE] [t/TIME] [l/LOCATION] [tag/TAG]...`

<div markdown="span" class="alert alert-primary">:bulb: **Note**: Editing the tags will automatically 
erase all previous tags!
</div>

Example: `edit 2 n/Ruth t/0730`

### 3.5 Finding a Consultation Event : `find`
Finds all events whose names contain any of the specified keywords and displays them as a list with index numbers.

Format: `find KEYWORD [MORE_KEYWORDS]...`

<div markdown="span" class="alert alert-primary">:bulb: **Note**: The keywords are case-insensitive!
</div>

Example: `find Jacob`

### 3.6 Viewing help : `help`

Opens a pop-up window with a link to  DukePro(f)'s user guide.

Format: `help`

### 3.7 Listing All Consultation Events : `list`
Lists down all consultations scheduled in DukePro(f).

Format: `list`

### 3.8 Exiting the app : `exit`
Exits DukePro(f).

Format: `exit`

### 3.9 Saving all edits
Event data is automatically saved into the hard disk after any command that changes the data. There is no
need to save manually.


## 4. FAQ
***
**Q**: Where are the releases?<br>
**A**: The release for v1.2 is a work in progress, please be patient!

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer, and overwrite the empty data file it creates with the file 
that contains the data of your previous DukePro(f) home folder.

**Q**: The dukeprof.jar isn’t opening when I double-click it.<br>
**A**: Try manually opening the dukeprof.jar on the command terminal using the command -java dukeprof.jar.
